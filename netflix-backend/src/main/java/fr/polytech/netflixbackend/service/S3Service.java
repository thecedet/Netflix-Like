package fr.polytech.netflixbackend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.http.Method;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class S3Service {
    
    private final MinioClient minioClient;
    private final SerieService serieService;

    @Value("${s3.bucketName.cover}")
    public String coverBucketName;
 
    @Value("${s3.bucketName.screenshot}")
    public String screenshotBucketName; 
 

    private String getPresignedUrl(Method method, String bucketName, String objectName) {
        try {
            return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                    .method(method)
                    .bucket(bucketName)
                    .object(objectName)
                    .build()
            );
        }catch (Exception e){
            System.out.println(e);
        }
        return "";
    }

    public String getGetCoverUrl(Integer id) {
        return this.getGetUrl(coverBucketName, id);
    }

    public String getPutCoverUrl(Integer id, String extension) {
        return this.getPutUrl(coverBucketName, id, extension);
    }

    public String getGetUrl(String bucketName, Integer id) {
        return this.getPresignedUrl(Method.GET, bucketName, this.serieService.getCover(id));
    }

    public String getPutUrl(String bucketName, Integer id, String extension) {
        this.serieService.addCover(id, extension);
        final String objectName = id + extension;
        return this.getPresignedUrl(Method.PUT, bucketName, objectName);
    }
}
