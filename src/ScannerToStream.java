import java.util.Objects;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Class to turn Scanner into a Stream
 * @author Betehtin Artem
 * @see Scanner
 * @see Stream
 */
class ScannerToStream{

    /**
     * Private class that generates supplier from a scanner, so then a stream can be generated from this supplier.
     *
     * @see Supplier
     */
    private static class ScannerToSupplier implements Supplier {

        private Scanner scanner;

        ScannerToSupplier(Scanner scanner){
            this.scanner = scanner;
        }

        /**
         * Supplies elements of the Scanner one by one. If Scanner runs out of elements, returns null.
         *
         * @return next element of the Supplier if it exist, else null
         */
        @Override
        public Object get() {
            if (scanner.hasNext()) {
                return scanner.next();
            }
            else {
                return null;
            }
        }
    }

    /**
     * Returns Stream generated from a Scanner using intermediate supplier.
     * If Scanner runs out of element, nulls from the Supplier will be discarded.
     *
     * @param scanner Scanner to convert to a Stream
     * @return Stream
     */
    static Stream getStream(Scanner scanner){
        ScannerToSupplier supplier = new ScannerToSupplier(scanner);
        return Stream.generate(supplier).filter(Objects::nonNull);
    }

}