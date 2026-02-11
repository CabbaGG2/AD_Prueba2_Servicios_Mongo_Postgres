package org.example.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "LosJojos")
public class LosJojos {
    private List<Saga> sagas;

    public List<Saga> getSagas() {
        return sagas;
    }

    public void setSagas(List<Saga> sagas) {
        this.sagas = sagas;
    }
}
