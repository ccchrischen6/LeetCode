import javax.swing.tree.TreeNode;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Trail {
    public int min(int[] array){
        if (array==null || array.length==0) return 0;
        Arrays.sort(array);
        return array[0];
    }

    public static void main(String[] args) throws IOException {

    }
}
