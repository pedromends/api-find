package pedro.apifind.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.apifind.VO.TaskVO;
import pedro.apifind.service.TaskService;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @PostMapping("/tasks")
    public ResponseEntity<Object> createTask(@RequestBody TaskVO taskVO) throws IOException {
		taskService.createTask(taskVO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/tasks")
    public ResponseEntity<Object> getTasks()  {
        return new ResponseEntity<>(taskService.listTask(), HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Object> getOneTask(@PathVariable("id") Long id) throws IOException {
        return new ResponseEntity<>(taskService.getOneTask(id), HttpStatus.OK);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Object> updateTask(@PathVariable("id") Long id, @RequestBody TaskVO taskVO) throws IOException {
        taskService.updateTask(taskVO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity deletarTask(@PathVariable Long id)  {
        taskService.deleteTask(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
