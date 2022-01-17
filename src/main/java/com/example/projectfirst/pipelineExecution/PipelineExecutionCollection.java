package com.example.projectfirst.pipelineExecution;

import com.example.projectfirst.pipeline.StepParameters;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Data
public class PipelineExecutionCollection {
    @Id
    private String id;
    private LocalDateTime startDate;
    private String state;
    private List<StepParameters> steps;
    private HashMap<String, String> output;
    private Integer numberOfExecutedSteps;

    public PipelineExecutionCollection(LocalDateTime startDate,
                                       String state,
                                       List<StepParameters> steps,
                                       HashMap<String, String> output,
                                       Integer numberOfExecutedSteps) {
        this.startDate = startDate;
        this.state = state;
        this.steps = steps;
        this.output = output;
        this.numberOfExecutedSteps = numberOfExecutedSteps;
    }
}