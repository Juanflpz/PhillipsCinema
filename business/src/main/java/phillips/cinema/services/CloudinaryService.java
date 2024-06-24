package phillips.cinema.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CloudinaryService {

    private Cloudinary cloudinary;
    private Map<String, String> config;

    public CloudinaryService(){
        config = new HashMap<>();
        config.put("cloud_name", "dxueuc0zo");
        config.put("api_key", "644786991283673");
        config.put("api_secret", "UGeFEqjdkh_P0I4BPiTutfdc5pQ");

        cloudinary = new Cloudinary(config);
    }

    public Map uploadImage(File file, String folder) throws Exception{
        Map response = cloudinary.uploader().upload(file, ObjectUtils.asMap("folder", folder));
        return response;
    }

    public Map deleteImage(String imageID) throws Exception{
        Map response = cloudinary.uploader().destroy(imageID, ObjectUtils.emptyMap());
        return response;
    }
}
