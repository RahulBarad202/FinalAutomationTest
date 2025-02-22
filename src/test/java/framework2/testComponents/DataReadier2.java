package framework2.testComponents;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;



public class DataReadier2 extends BaseClass{
 public static String jsonFilePath="E:\\8PMbatch\\SeleniumFrameworkDesign2\\src\\test\\java\\framework2\\data\\products.json";
	//program to read json data file
	
	public static List<HashMap<String, String>> getjsonObject() throws IOException {
		File f=new File(jsonFilePath);
		String jsonContent=FileUtils.readFileToString(f, StandardCharsets.UTF_8);
		//convert json to hashmap
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String,String>> hashmapobjs=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
		});
		return hashmapobjs;
	}
}
