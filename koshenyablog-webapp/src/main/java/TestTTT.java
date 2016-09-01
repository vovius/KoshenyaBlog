import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * Created by sony on 8/27/2016.
 */
public class TestTTT {

    ConcurrentMap<String, Integer> resultsMap = new ConcurrentHashMap<String, Integer>();

    public void start(Object o) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(() -> { return "Task 1"; } );
        callables.add(() -> { return "Task 2"; } );
        callables.add(() -> { return "Task 3"; } );

        try {
            String result = service.invokeAny(callables);
            Integer resultCount = resultsMap.getOrDefault(result, 0);
            resultsMap.put(result, ++resultCount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }

    public void printResults() {
        resultsMap.keySet().forEach((key)-> {
            Integer resultCount = resultsMap.get(key);
            System.out.println(key+"="+resultCount);

        });
    }

    public static void main(String[] args) {
        TestTTT ttt = new TestTTT();
        IntStream.rangeClosed(1,10000).forEach(ttt::start);
        ttt.printResults();
    }
}
