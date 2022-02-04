package com.example.projectfirst.pipelineExecution.services;

import com.example.projectfirst.pipelineExecution.PipelineExecutionRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
@Slf4j
public class SaveOutputService {
    @Autowired
    private PipelineExecutionRepository pipelineExecutionRepository;

    public void save(String pipelineExeId, String response, String name){
        log.info("Execution successful! Saving result of this step!");
        pipelineExecutionRepository.findById(pipelineExeId)
                .map(pipelineExecution -> {
                    JSONObject json = new JSONObject(response);
                    HashMap<String, String> output = pipelineExecution.getOutput();
                    output.put(name, json.toString(4));
                    pipelineExecution.setOutput(output);

                    Integer numberOfExecutedSteps = pipelineExecution.getNumberOfExecutedSteps();
                    numberOfExecutedSteps += 1;
                    pipelineExecution.setNumberOfExecutedSteps(numberOfExecutedSteps);

                    pipelineExecutionRepository.save(pipelineExecution);
                    return null;
                });
    }
}
