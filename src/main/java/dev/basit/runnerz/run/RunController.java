package dev.basit.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final JdbcRunRepository jdbcRunRepository;

    public RunController(JdbcRunRepository jdbcRunRepository) {
        this.jdbcRunRepository = jdbcRunRepository;
    }

    @GetMapping("")
    List<Run> findAll() {
        return jdbcRunRepository.findAll();
    }

    //
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = jdbcRunRepository.findById(id);
//        return run.orElseThrow(() -> new RunNotFoundException());
        return run.orElseThrow(RunNotFoundException::new);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Run run) {
        jdbcRunRepository.create(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Run run, @PathVariable Integer id) {
        jdbcRunRepository.update(run, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        jdbcRunRepository.delete(id);
    }

}
