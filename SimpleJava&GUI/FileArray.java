import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


class FileArray {

    public static void writeArray(String file, int[] nums) throws IOException {
        DataOutputStream writer = new DataOutputStream(new FileOutputStream(file));

        for (int integer : nums) {
            writer.writeInt(integer);
        }
        writer.close();
    }

    public static void readArray(String file, int[] array) throws IOException {
        DataInputStream reader = new DataInputStream(new FileInputStream(
            file));
        int i = 0;
        while(reader.available() > 0){
            int num = reader.readInt();
            array[i] = num;
            i++; 
        }
        reader.close();
    }
}