package us.codecraft.serializers.utils;

/**
 * @author yihua.huang@dianping.com <br>
 * @date: 13-7-13 <br>
 *        Time: 下午4:16 <br>
 */
public abstract class ByteDumper {

	private static int bytesPerLine = 10;

	public static String dumperArray(byte[] bytes) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			stringBuilder.append(dump(bytes[i]) + " ");
			if (i > 0 && (i + 1) % bytesPerLine == 0) {
				stringBuilder.append("\n");
			} else if ((i + 1) % (bytesPerLine / 2) == 0) {
				stringBuilder.append("\t");
			}
		}
		return stringBuilder.toString();
	}

	public static String dump(byte aByte) {
		String s = Integer.toHexString(((int) aByte & 0xff)).toUpperCase();
		if (s.length() < 2) {
			s = "0" + s;
		}
		return s;
	}

}
