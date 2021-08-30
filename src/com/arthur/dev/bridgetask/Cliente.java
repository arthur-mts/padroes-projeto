package com.arthur.dev.bridgetask;

import com.arthur.dev.bridgetask.janelas.JanelaAbstrata;
import com.arthur.dev.bridgetask.janelas.JanelaAndroid;
import com.arthur.dev.bridgetask.janelas.JanelaDialog;
import com.arthur.dev.bridgetask.janelas.JanelaDownload;
import com.arthur.dev.bridgetask.janelas.JanelaIMP;
import com.arthur.dev.bridgetask.janelas.JanelaLinux;
import com.arthur.dev.bridgetask.janelas.JanelaWindows;

public class Cliente {
    public static void main(String[] args) {
        JanelaIMP janelaLinux = new JanelaLinux();
        JanelaIMP janelaAndoird = new JanelaAndroid();
        JanelaIMP janelaWindows = new JanelaWindows();

        JanelaAbstrata dialog = new JanelaDialog(janelaAndoird);
        dialog.desenhar();

        dialog.setJanela(janelaLinux);
        dialog.desenhar();

        dialog.setJanela(janelaWindows);
        dialog.desenhar();

        JanelaAbstrata download = new JanelaDownload(janelaAndoird);

        download.setJanela(janelaLinux);
        download.desenhar();

        download.setJanela(janelaWindows);
        download.desenhar();
    }
}
