package ocp2;

public class StreamAboutStream {

	/*
	 
	 Which statement is true about java.util.stream.Stream?
	 A. A stream cannot be consumed more than once.
	 B. The execution mode of streams can be changed during processing.
	 C. Streams are intended to modify the source data.
	 D. A parallel stream is always faster than an equivalent sequential stream
 
	 */
	
	/*
	 * correct answer is:
	 	A. A stream cannot be consumed more than once.
		True.
		Streams in Java are single-use objects. Once a terminal operation 
		(like forEach, collect, or reduce) is executed, the stream is considered consumed, 
		and you cannot reuse or traverse it again. 
		Attempting to reuse it will throw an IllegalStateException.


		Incorrect Options:
		B. The execution mode of streams can be changed during processing.
		False.
		The execution mode (sequential or parallel) is determined when the stream is created 
		or explicitly switched using parallel() or sequential(). 
		It cannot be dynamically changed during processing.
		
		C. Streams are intended to modify the source data.
		False.
		Streams are designed to process data without modifying the underlying source. 
		Operations on streams produce results based on transformations but do not change the original data.
		
		D. A parallel stream is always faster than an equivalent sequential stream.
		False.
		While parallel streams can take advantage of multiple CPU cores, 
		they are not guaranteed to be faster than sequential streams. 
		Factors such as the size of the data set, the nature of the operations, and the system's architecture influence the performance. For small data sets or lightweight operations, sequential streams may be faster.

	 */
}
