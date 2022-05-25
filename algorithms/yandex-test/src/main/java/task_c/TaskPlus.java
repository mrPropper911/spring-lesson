package task_c;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class TaskPlus {
    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary)
                Native.load((Platform.isWindows() ? "msvcrt" : "c"),
                        CLibrary.class);

        void printf(String format, Object... args);
        void fill_buffer(int[] buf, int len);

    }

    public static void main(String[] args) {
        CLibrary.INSTANCE.printf("Hello, World\n");
        for (int i=0;i < args.length;i++) {
            CLibrary.INSTANCE.printf("Argument %d: %s\n", i, args[i]);
        }
        int[] ad = {2,3};
        CLibrary.INSTANCE.fill_buffer(ad,2);

    }
}
