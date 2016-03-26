package com.virginiatech.ece.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import com.virginiatech.ece.AzureBlobInitializer;
import com.virginiatech.ece.daoImpl.TestImpl;
import com.virginiatech.ece.model.Temp;
import com.virginiatech.ece.model.UploadLog;
import com.virginiatech.ece.repository.TestRepository;
import com.virginiatech.ece.repository.UploadLogRepository;

@Service
public class UploadLogServiceImpl implements UploadLogService {
	SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-dd-YYYY_hh:mm:ss");

	@Value("${azure.blob.storageContainerName}")
	private String storageContainerName;

	private UploadLogRepository uploadRepository;
	private TestRepository testRepository;
	private TestImpl testDao;
	private AzureBlobInitializer blobInitializer;

	@Autowired
	public void setBlobInitializer(AzureBlobInitializer blobInitializer) {
		this.blobInitializer = blobInitializer;
	}

	@Autowired
	public void setUploadRepository(UploadLogRepository uploadRepository) {
		this.uploadRepository = uploadRepository;
	}

	@Autowired
	public void setTestRepository(TestRepository testRepository) {
		this.testRepository = testRepository;
	}

	@Autowired
	public void setTestDao(TestImpl testDao) {
		this.testDao = testDao;
	}

	public List<UploadLog> findUploads() {

		return this.uploadRepository.findAll();
	}

	public List<Temp> findTestData() {

		return this.testRepository.findAll();
	}

	public void uploadData(MultipartFile inventoryFile)
			throws IOException, InvalidKeyException, URISyntaxException, StorageException {
		File infoFile = convert(inventoryFile);
		String currentDate = dateFormatter.format(new Date());
		String fileName = "Inventory_Data_" + currentDate
				+ infoFile.getPath().substring(infoFile.getPath().lastIndexOf("."));
		CloudBlobContainer container = blobInitializer.getcontainer(storageContainerName);
		FileInputStream inputStream = new FileInputStream(infoFile);
		CloudBlockBlob blob = container.getBlockBlobReference(fileName);
		blob.upload(inputStream, infoFile.length());
		UploadLog log = new UploadLog();
		log.setUploadDate(currentDate);
		log.setUploadLocation(blob.getQualifiedStorageUri().getPrimaryUri().toString());
		log.setUploadName(fileName);
		saveLogData(log);
		inputStream.close();
		inputStream = new FileInputStream(infoFile);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();
		List<Temp> mainTableEntries = new ArrayList<Temp>();
		iterator.next(); // skip 1st line
		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			mainTableEntries.add(populateFileData(cellIterator));
		}
		inputStream.close();
		testDao.bulkSave(mainTableEntries);

	}

	public void saveLogData(UploadLog log) {
		uploadRepository.save(log);
	}

	public File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

	private Temp populateFileData(Iterator<Cell> cellIterator) {
		Temp rowEntry = new Temp();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			switch (cell.getColumnIndex()) {
			case 0:
				rowEntry.setCol_Owner(cell.getStringCellValue());
				break;
			case 1:
				rowEntry.setCol_Orgn_Code(cell.getStringCellValue());
				break;
			case 2:
				rowEntry.setCol_Orgn_Title(cell.getStringCellValue());
				break;
			case 3:
				rowEntry.setCol_Room(cell.getStringCellValue());
				break;
			case 4:
				rowEntry.setCol_Bldg(cell.getStringCellValue());
				break;
			case 5:
				rowEntry.setCol_Sort_Room(cell.getStringCellValue());
				break;
			case 6:
				rowEntry.setCol_Ptag(cell.getStringCellValue());
				break;
			case 7:
				rowEntry.setCol_Manufacturer(cell.getStringCellValue());
				break;
			case 8:
				rowEntry.setCol_Model(cell.getStringCellValue());
				break;
			case 9:
				rowEntry.setCol_Serial_Number(cell.getStringCellValue());
				break;
			case 10:
				rowEntry.setCol_Description(cell.getStringCellValue());
				break;
			case 11:
				rowEntry.setCol_Custodian(cell.getStringCellValue());
				break;
			case 12:
				rowEntry.setCol_PO(cell.getStringCellValue());
				break;
			case 13:
				rowEntry.setCol_Acq_Date(cell.getStringCellValue());
				break;
			case 14:
				rowEntry.setCol_Amt(cell.getStringCellValue());
				break;
			case 15:
				rowEntry.setCol_Ownership(cell.getStringCellValue());
				break;
			case 16:
				rowEntry.setCol_Schev_Year(cell.getStringCellValue());
				break;
			case 17:
				rowEntry.setCol_Tag_Type(cell.getStringCellValue());
				break;
			case 18:
				rowEntry.setCol_Asset_Type(cell.getStringCellValue());
				break;
			case 19:
				rowEntry.setCol_Atyp_Title(cell.getStringCellValue());
				break;
			case 20:
				rowEntry.setCol_Condition_State(cell.getStringCellValue());
				break;
			case 21:
				rowEntry.setCol_Last_Inv_Date(cell.getStringCellValue());
				break;
			case 22:
				rowEntry.setCol_Designation(cell.getStringCellValue());
				break;
			}
		}
		return rowEntry;
	}

}
