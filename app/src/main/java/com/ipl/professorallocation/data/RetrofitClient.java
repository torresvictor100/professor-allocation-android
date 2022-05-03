package com.ipl.professorallocation.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static final String URL_BASE = "https://muribequers-backend.herokuapp.com";


    public static Retrofit getInstance() {
        if(retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create(gsonConverters()))
                    .build();
        }
        return retrofit;
    }

    public static ProfessorService getProfessorService() {
        if (retrofit == null) {
            getInstance();
        }
       return retrofit.create(ProfessorService.class);
    }

    public static DepartamentoService getDepartamentoService(){
        if(retrofit == null){
            getInstance();
        }
        return retrofit.create(DepartamentoService.class);
    }

    public static CursoService getCursoService() {
        if (retrofit == null) {
            getInstance();
        }
        return retrofit.create(CursoService.class);
    }

    public static AllocationService getAllocationService(){
        if(retrofit==null){
            getInstance();
        }
        return retrofit.create(AllocationService.class);
    }

    public static Gson gsonConverters() {
        final GsonBuilder builder = new GsonBuilder();

        // Converter a string de hora, minuto e timezone (14:31+0000) enviada pelo backend para o
        // tipo LocalTime do java. (14:31)
        builder.registerTypeAdapter(LocalTime.class, (JsonDeserializer<LocalTime>) (je, type, jdc) ->
                LocalTime.parse(je.getAsString(), DateTimeFormatter.ofPattern("HH:mmZ"))
        );

        // Converter LocalTime de hora, minuto (14:31) utilizado na plaicação para o
        // tipo  do backend adicionando time zone (14:31+0000)
        builder.registerTypeAdapter(LocalTime.class, (JsonSerializer) (src, typeOfSrc, context) ->
                new JsonPrimitive(src.toString()+"+0000")
        );

        return builder.create();
    }
}
