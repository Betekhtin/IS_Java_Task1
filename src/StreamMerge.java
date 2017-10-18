import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Class to merge two input streams into one stream that alternates their elements
 * @author Betehtin Artem
 */
class StreamMerge {

    /**
     * Make a stream that alternates elements from two finite streams
     *
     * @param first_stream first stream
     * @param second_stream second stream
     * @return merged steam
     */
    static Stream merge(Stream first_stream, Stream second_stream){
        Iterator first_iter = first_stream.iterator();
        Iterator second_iter = second_stream.iterator();
        List result = new ArrayList();
        while(first_iter.hasNext() && second_iter.hasNext()){
            result.add(first_iter.next());
            result.add(second_iter.next());
        }
        return result.stream();
    }

}
