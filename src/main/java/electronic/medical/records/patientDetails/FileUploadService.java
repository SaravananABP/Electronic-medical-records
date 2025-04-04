package electronic.medical.records.patientDetails;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileUploadService {

    // The directory where files will be stored (in case you want to store the encrypted files as files as well)
//    @Value("${file-upload-dir}")
    private String uploadDir="nnnn";

    // This method will handle storing the file as encrypted bytes
    public byte[] storeEncryptedFile(MultipartFile file) throws IOException, Exception {
        byte[] fileBytes = file.getBytes();  // Get the file content as byte array
        return EncryptionUtils.encrypt(fileBytes);  // Encrypt the file content
    }

    // You can also store the encrypted file in the database and return the file bytes for later decryption
    public byte[] storeEncryptedFile(byte[] fileBytes) throws Exception {
        return EncryptionUtils.encrypt(fileBytes);  // Encrypt the file content
    }

    // Optional: Save the encrypted file to the server (if needed)
    public String storeEncryptedFileOnDisk(MultipartFile file) throws IOException, Exception {
        byte[] encryptedBytes = storeEncryptedFile(file);
        String encryptedFilePath = uploadDir + "/" + file.getOriginalFilename() + ".enc";  // Save as .enc file

        // Store the encrypted file to the disk (optional)
        java.nio.file.Files.write(java.nio.file.Paths.get(encryptedFilePath), encryptedBytes);
        return encryptedFilePath;
    }
}

