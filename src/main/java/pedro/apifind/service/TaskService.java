package pedro.apifind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pedro.apifind.VO.TaskVO;
import pedro.apifind.entity.Task;
import pedro.apifind.repository.TaskRepository;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void createTask(TaskVO taskVO) throws Exception {
        try{
            if(taskVO.getTitle() != null && taskVO.getDescription() != null && taskVO.getStatus() != null  && taskVO.getDateCreation() != null ){
                Task task = new Task();

                task.setTitulo(taskVO.getTitle());
                task.setDescricao(taskVO.getDescription());
                task.setStatus(taskVO.getStatus());
                task.setDataCriacao(taskVO.getDateCreation());
                task.setDataAtualizacao(taskVO.getDateUpdate());

                taskRepository.save(task);
            }

        }catch(Exception e){
            throw new Exception("Preencha todas as informações", e);
        }
    }

    public List<TaskVO> listTask(){

        List<TaskVO> listVO = new ArrayList<>();
        List<Task> list = taskRepository.findAll();

        for(Task task : list)
            listVO.add(new TaskVO(task));

        return listVO;
    }

    public TaskVO getOneTask(Long id) throws IOException {
        Task task = taskRepository.getById(id);
        return new TaskVO(task);
    }

    public void updateTask(TaskVO taskVO) throws IOException {

		Task task = taskRepository.getById(taskVO.getId());

        task.setTitulo(taskVO.getTitle());
        task.setDescricao(taskVO.getDescription());
        task.setStatus(taskVO.getStatus());
        task.setDataCriacao(taskVO.getDateCreation());
        task.setDataAtualizacao(Date.from(Instant.now()));

		taskRepository.save(task);
    }

    public HttpStatus deleteTask(Long id){
		taskRepository.deleteById(id);
		return HttpStatus.OK;
    }
}
