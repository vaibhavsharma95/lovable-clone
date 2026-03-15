package com.demo.lovable_clone.service.impl;

import com.demo.lovable_clone.dto.project.FileContentResponse;
import com.demo.lovable_clone.dto.project.FileNode;
import com.demo.lovable_clone.service.FileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public List<FileNode> getFileTree(Long projectId, Long userId) {
        return null;
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }
}
