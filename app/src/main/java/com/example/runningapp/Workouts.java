package com.example.runningapp;

public class Workouts {

    String WRKNAME,DATE, NUMREPS,REPDIST,WRKTYPE;

        public Workouts(String WRKNAME, String DATE, String NUMREPS, String REPDIST, String WRKTYPE) {
            this.WRKNAME = WRKNAME;
            this.DATE = DATE;
            this.NUMREPS = NUMREPS;
            this.REPDIST = REPDIST;
            this.WRKTYPE= WRKTYPE;
        }

        public String getWRKNAME() {
            return WRKNAME;
        }

        public String getDATE() {
            return DATE;
        }

        public String getNUMREPS(){return NUMREPS; }

        public String getREPDIST() {
            return REPDIST;
        }

        public String getWRKTYPE(){return WRKTYPE;}


}
