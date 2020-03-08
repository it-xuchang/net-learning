package com.netlearning.framework.domain.course.result;

import com.netlearning.framework.domain.userAuth.result.TeacherResult;
import lombok.Data;

import java.util.List;

/**
 * @program: net-learning
 * @description:
 * @author: XUCHANG
 * @time: 2020/2/8 19:49
 */
@Data
public class CourseAllDetailResult {
    private boolean isLearning;
    private Double courseCountTime;
    private Double courseAssessmentGrade;
    private CourseBaseResult courseBaseResult;
    private TeacherResult teacherResult;
    private CategoryResult categoryResult;
    private List<TeachPlanResult> teachPlans;
    private List<FrequentlyAskedQuestionResult> frequentlyAskedQuestionResults;
    private List<CourseAssessmentResult> courseAssessmentResults;
    private List<CourseQuziResult> courseQuziResults;
}
