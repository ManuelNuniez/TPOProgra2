package impl;

import api.PilaTDA;

public class PilaEstatica implements PilaTDA {
    
        int[] vector;
        int i;

        @Override
        public void InicializarPila() {
            vector = new int[100];
            i = 0;
        }

        @Override
        public void Apilar(int x) {
            vector[i] = x;
            i++;
        }

        @Override
        public void Desapilar() {
            i--;
        }

        @Override
        public int Tope() {
            return(vector[i-1]);
        }

        @Override
        public boolean PilaVacia() {
            return(i == 0);
        }
}
