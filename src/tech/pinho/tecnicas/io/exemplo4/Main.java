package tech.pinho.tecnicas.io.exemplo4;

import tech.pinho.banco.model.Owner;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        try(ObjectOutputStream objectOutputStream =new ObjectOutputStream(new FileOutputStream("owner.obj"))) {
            Owner owner = new Owner();
            owner.setNome("Bruno");
            owner.setCpf("123456789");
            owner.setDataNascimento(LocalDate.now());
            objectOutputStream.writeObject(owner);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
