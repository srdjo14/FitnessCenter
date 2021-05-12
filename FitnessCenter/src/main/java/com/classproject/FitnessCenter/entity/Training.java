package com.classproject.FitnessCenter.entity;

import javax.persistence.*;
import java.io.Serializable;
import javafx.util.Builder;

import javax.persistence.*;
import java.io.Serializable;



    @Entity
    public class Training implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "training_name", unique = true, nullable = false)
        private String name;

        @Column(name = "about", length = 120, nullable = false)
        private String aboutTraining;

        @Column(name = "type", nullable = false)
        private String typeOfTraining;

        @Column(name = "length", nullable = false)
        private Integer length;

        @Column(name = "done", nullable = false)
        private Boolean doneTrainingCheck;

        @Column(name = "logged", nullable = false)
        private Boolean regTrainingCheck;

        /* Automatski postavljeno da nam je nullable=true, tako da moze biti i 0 */
        @Column(name = "rated")
        private Integer rated;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAboutTraining() {
            return aboutTraining;
        }

        public void setAboutTraining(String aboutTraining) {
            this.aboutTraining = aboutTraining;
        }

        public String getTypeOfTraining() {
            return typeOfTraining;
        }

        public void setTypeOfTraining(String typeOfTraining) {
            this.typeOfTraining = typeOfTraining;
        }

        public Integer getLength() {
            return length;
        }

        public void setLength(Integer length) {
            this.length = length;
        }

        public Boolean getDoneTrainingCheck() {
            return doneTrainingCheck;
        }

        public void setDoneTrainingCheck(Boolean doneTrainingCheck) {
            this.doneTrainingCheck = doneTrainingCheck;
        }

        public Boolean getRegTrainingCheck() {
            return regTrainingCheck;
        }

        public void setRegTrainingCheck(Boolean regTrainingCheck) {
            this.regTrainingCheck = regTrainingCheck;
        }

        public Integer getRated() {
            return rated;
        }

        public void setRated(Integer rated) {
            this.rated = rated;
        }

        @Override
        public String toString(){
            return "Training{" +
                    "id=" + id +
                    ", name=" + name + '\'' +
                    ", type=" + typeOfTraining + '\'';
        }
    }


