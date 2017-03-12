package cn.victorlee.assist;

public class TestZipCBA {

	public static void main(String[] args) {
		ZipCompressorByAnt zcba = new ZipCompressorByAnt("/usr/local/tomcat8/webapps/share/test.zip");
		zcba.compressExe("/home/homework/仲恺农业工程学院/信计133班/JAVA应用技术/2");

	}

}
