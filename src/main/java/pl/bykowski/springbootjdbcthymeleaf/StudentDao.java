package pl.bykowski.springbootjdbcthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void save() {
        String sql = "INSERT INTO student VALUES(?, ?, ?, ?)";
        jdbcTemplate.update(sql, new Object[]
                {1, "Jan", "Kowalski", 3});
    }


    @EventListener(ApplicationReadyEvent.class)
    public void dbInit() {
        save();
    }


}
