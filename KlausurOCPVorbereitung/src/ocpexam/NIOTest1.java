package ocpexam;

public class NIOTest1 {

	
	/*
	 Given that these files exist and are accessible:
	
	/sports/info.txt
	
	/sports/cricket/players.txt
	
	/sports/cricket/data/ODI.txt
	
	and given the code fragment:
	
	int maxDepth =2;
	
	Stream<Path> paths = Files.find(Paths.get(''/sports''),
	
	maxDepth,
	
	(p, a) -> p.getFileName().toString().endsWith (''txt''),
	
	FileVisitOption.FOLLOW_LINKS);
	
	Long fCount = paths.count();
	
	System.out.println(fCount);
	
	Assuming that there are NO soft-link/symbolic links to any of the files in the directory structure, what is the result?
	
	
	
	Options
	A	1
	B	2
	C	3
	D	An Exception is thrown at runtime.
	
	
	Answer
	D
 */
}
