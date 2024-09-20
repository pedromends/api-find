package pedro.apifind.VO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import pedro.apifind.entity.Task;

import java.util.Date;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskVO {

	private Long id;
    private String title;
    private String description;
    private String status;
    private Date dateCreation;
    private Date dateUpdate;

    public TaskVO(Task task){
		this.id  = task.getId();
        this.title = task.getTitulo();
        this.description = task.getDescricao();
        this.status  = task.getStatus();
        this.dateCreation = task.getDataCriacao();
        this.dateUpdate = task.getDataAtualizacao();
    }
}
