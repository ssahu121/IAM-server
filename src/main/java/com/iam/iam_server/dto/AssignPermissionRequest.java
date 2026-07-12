package com.iam.iam_server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssignPermissionRequest {

    private Long roleId;

    private Long permissionId;
}