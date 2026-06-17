package com.tarea.tienda;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.*;

public class ProductoController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtStock;

    @FXML
    private Label lblMsg;

    @FXML
    private TableView<Producto> tblProductos;

    @FXML
    private TableColumn<Producto,Integer> colId;

    @FXML
    private TableColumn<Producto,String> colNombre;

    @FXML
    private TableColumn<Producto,Double> colPrecio;

    @FXML
    private TableColumn<Producto,Integer> colStock;

    @FXML
    public void initialize() {

        colId.setCellValueFactory(
                new PropertyValueFactory<>("id"));

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));

        colPrecio.setCellValueFactory(
                new PropertyValueFactory<>("precio"));

        colStock.setCellValueFactory(
                new PropertyValueFactory<>("stock"));
    }

    @FXML
    private void guardar() {

        if(txtNombre.getText().isEmpty()
                || txtPrecio.getText().isEmpty()
                || txtStock.getText().isEmpty()) {

            lblMsg.setText("Complete todos los campos");
            return;
        }

        String sql =
                "INSERT INTO productos(nombre,precio,stock) VALUES(?,?,?)";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, txtNombre.getText());
            ps.setDouble(2, Double.parseDouble(txtPrecio.getText()));
            ps.setInt(3, Integer.parseInt(txtStock.getText()));

            ps.executeUpdate();

            lblMsg.setText("Guardado correctamente");

            limpiar();
            mostrar();

        } catch(Exception e) {
            lblMsg.setText("Error");
            e.printStackTrace();
        }
    }

    @FXML
    private void mostrar() {

        ObservableList<Producto> lista =
                FXCollections.observableArrayList();

        String sql = "SELECT * FROM productos";

        try(Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {

                lista.add(new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                ));
            }

            tblProductos.setItems(lista);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void limpiar() {

        txtNombre.clear();
        txtPrecio.clear();
        txtStock.clear();

        txtNombre.requestFocus();
    }

    @FXML
    private void salir() {

        Stage stage =
                (Stage) txtNombre.getScene().getWindow();

        stage.close();
    }
}