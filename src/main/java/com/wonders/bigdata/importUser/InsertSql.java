package com.wonders.bigdata.importUser;

/**
 * Description: <br>
 *
 * @author: XB
 * @date: 2020/3/5 14:46
 */
public class InsertSql {
    public static void main(String[] args) {
        try {
            String[] files = {"伦理批件-1-1","意见函-2-2","跟踪审查表-3-3"};
            String[] shishi = {"SEA说明-4-4","项目进度报告-5-5"};
            int i = 61;
            int j = 606;
            for (String s : files) {
                String[] str = s.split("-");
                String sql = "INSERT INTO `bd_dic_project_model_file` VALUES (" + i + ", 0, NULL, '" + str[0] + "', NULL, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + j + ",0, " + i + ", 'eq', 'dic_research_type_id', '1', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+1) + "," + j + ", " + i + ", 'eq', 'step_id', '2', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+2) + "," + (j+1) + ", " + i + ", 'eq', 'task_type', '100', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+3) + ",0, " + i + ", 'eq', 'dic_research_type_id', '2', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+4) + "," + (j+3) + ", " + i + ", 'eq', 'step_id', '2', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+5) + "," + (j+4) + ", " + i + ", 'eq', 'task_type', '100', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+6) + ",0, " + i + ", 'eq', 'dic_research_type_id', '3', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+7) + "," + (j+6) + ", " + i + ", 'eq', 'step_id', '2', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+8) + "," + (j+7) + ", " + i + ", 'eq', 'task_type', '100', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+9) + ",0, " + i + ", 'eq', 'dic_research_type_id', '4', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+10) + "," + (j+9) + ", " + i + ", 'eq', 'step_id', '2', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+11) + "," + (j+10) + ", " + i + ", 'eq', 'task_type', '100', 0, 0, 1, " + str[1] +", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                j = j+12;
                i++;
            }
            for (String s : shishi) {
                String[] str = s.split("-");
                String sql = "INSERT INTO `bd_dic_project_model_file` VALUES (" + i + ", 0, NULL, '" + str[0] + "', NULL, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + j + ",0, " + i + ", 'eq', 'dic_research_type_id', '1', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+1) + "," + j + ", " + i + ", 'eq', 'step_id', '5', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+2) + "," + (j+1) + ", " + i + ", 'eq', 'task_type', '100', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+3) + ",0, " + i + ", 'eq', 'dic_research_type_id', '2', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+4) + "," + (j+3) + ", " + i + ", 'eq', 'step_id', '5', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+5) + "," + (j+4) + ", " + i + ", 'eq', 'task_type', '100', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+6) + ",0, " + i + ", 'eq', 'dic_research_type_id', '3', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+7) + "," + (j+6) + ", " + i + ", 'eq', 'step_id', '5', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+8) + "," + (j+7) + ", " + i + ", 'eq', 'task_type', '100', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+9) + ",0, " + i + ", 'eq', 'dic_research_type_id', '4', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+10) + "," + (j+9) + ", " + i + ", 'eq', 'step_id', '5', 0, 0, 1, " + str[1] + ", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                sql = "INSERT INTO `bd_dic_project_model_file_rule` VALUES (" + (j+11) + "," + (j+10) + ", " + i + ", 'eq', 'task_type', '100', 0, 0, 1, " + str[1] +", '" + str[2] + "', 0, '2020-03-05 13:58:17', '2020-03-05 13:58:17', 0);";
                System.out.println(sql);
                j = j+12;
                i++;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
