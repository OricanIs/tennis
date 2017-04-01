import static com.tennis.util.common.http.DownloadFileUtil.downLoadFromUrl;


public class DownloadImage {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		download();
	}

	public static void download() throws Exception {

		String rootUrl = "http://my.sit.edu.cn/attachmentDownload" +
				".portal?type=userFace&ownerId=";
		String rootNo = "121042Y";
		String downloadRoot = "/Users/lixiao/Documents/photos";
		int no = 111 ;
		boolean hasNext = true;
		while (hasNext){
			String filename = rootNo+no;
			// 构造URL
			System.out.println(rootUrl+filename);
			downLoadFromUrl(rootUrl+filename,filename+".jpg",downloadRoot);
			no += 1;

		}


	}


}  