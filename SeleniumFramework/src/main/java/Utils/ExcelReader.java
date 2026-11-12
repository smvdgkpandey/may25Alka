package Utils;

import java.io.IOException;

public interface ExcelReader {
	
	
	public  String readExcelData(String path,String sheet,int row,int col) throws IOException;

}
