package com.SpringBoot.Program.SpringBootReact.Repository;

import com.SpringBoot.Program.SpringBootReact.Model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Repository  extends JpaRepository<UserTable,Integer> {
}
