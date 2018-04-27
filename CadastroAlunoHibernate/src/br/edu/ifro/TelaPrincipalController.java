/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

import br.edu.ifro.modelo.Aluno;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author 3019657
 */
public class TelaPrincipalController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button btnMensagem;
    @FXML
    private TextField txt1;
    @FXML
    private TextField txt2;
    @FXML
    private TextField txt3;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    @FXML
    private TableView tbAlunos;
    
    // import javafx.collections.FXCollections;
    // import javafx.collections.ObservableList;
    // import java.util.List;
    // import br.edu.ifro.modelo.Aluno   
    // import javax.persistence.EntityManager;
    // import javax.persistence.EntityManagerFactory;
    // import javax.persistence.Persistence;
    // import javax.persistence.Query;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT a FROM Aluno a");
        List<Aluno> alunos = query.getResultList();
        ObservableList<Aluno> obAlunos = FXCollections.observableArrayList(alunos);
        tbAlunos.setItems(obAlunos);
        em.close();
        emf.close();        
    }

    @FXML
    private void exibir(ActionEvent event) {
                try {
            Scene scene = (Scene) txt3.getScene();        
        scene.setFill(Color.TRANSPARENT);
        } catch (Exception e) {
        }
        txt1.setText("deu certo");
    }
    
}
