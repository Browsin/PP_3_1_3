package ru.kata.spring.boot_security.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "role")
   private String role;

   @ManyToMany(mappedBy = "roles")
   private Set<User> users = new HashSet<>();

   @Override
   public String getAuthority() {
      return getRole();
   }

   @Override
   public String toString() {
      return getRole();
   }
}
