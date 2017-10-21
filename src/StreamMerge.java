import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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
    static Stream merge(Stream first_stream, Stream second_stream) {
        Alternator alter = new Alternator(first_stream.iterator(), second_stream.iterator());
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(alter, Spliterator.ORDERED), false);
    }

}


/**
 * Class that implements iterator to alternate elements from two iterators
 * @author Betehtin Artem
 */
class Alternator implements Iterator{

    private Iterator first_iterator;
    private Iterator second_iterator;
    private boolean fromFirst;
    private boolean hasNext;

    Alternator(Iterator first_iterator, Iterator second_iterator) {
        this.first_iterator = first_iterator;
        this.second_iterator = second_iterator;
        fromFirst = true;
        hasNext = true;
    }

    @Override
    public boolean hasNext() {
        if (hasNext) {
            if (first_iterator.hasNext() != second_iterator.hasNext()) hasNext = false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object next() {
        Object result = (fromFirst)? first_iterator.next() : second_iterator.next();
        fromFirst = !fromFirst;
        return result;
    }

}