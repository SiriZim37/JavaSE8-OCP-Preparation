package ocpexam;

public class StreamTest5 {

	/*
	 MultipleChoice *** IN OCP ***

	Given the code fragment:
	
	List<String> codes = Arrays.asList (''DOC'', ''MPEG'', ''JPEG'');
	
	codes.forEach (c -> System.out.print(c + '' ''));
	
	String fmt = codes.stream()
	
	.filter (s-> s.contains (''PEG''))
	
	.reduce((s, t) -> s + t).get();
	
	System.out.println(''\n'' + fmt);
	
	What is the result?
	
	
	
	Options
	A	DOC MPEG JPEGMPEGJPEG
	B	DOC MPEG MPEGJPEGMPEGMPEGJPEG
	C	MPEGJPEGMPEGJPEG
	D	The order of the output is unpredictable.
	
	Answer
	A
	 */
}
