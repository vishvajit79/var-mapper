package io.qhacks.var_mapper;

import java.util.List;

import clarifai2.api.ClarifaiBuilder;
import clarifai2.api.ClarifaiClient;
import clarifai2.dto.input.ClarifaiInput;
import clarifai2.dto.model.output.ClarifaiOutput;
import clarifai2.dto.prediction.Concept;
import okhttp3.OkHttpClient;

/**
 * Created by james on 2/3/2018.
 */

public class Clarifai_Process {
    private final String API_KEY = "d584f38ca7ba42d2909b5a149162d790";
    private ClarifaiClient client;

    public Clarifai_Process(){
        client = new ClarifaiBuilder(API_KEY)
                .client(new OkHttpClient()) // OPTIONAL. Allows customization of OkHttp by the user
                .buildSync();
    }

    public ClarifaiOutput<Concept> getCategories(byte[] imageBytes){
        List<ClarifaiOutput<Concept>> predictionResults =
            client.getDefaultModels().generalModel() // You can also do client.getModelByID("id") to get your custom models
                    .predict()
                    .withInputs(
                            ClarifaiInput.forImage(imageBytes))
                    .executeSync()
                    .get();


        return predictionResults.get(0);
    }
}
