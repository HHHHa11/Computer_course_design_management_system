package com.design.entity;

import java.util.ArrayList;
import java.util.List;

public class TopicExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table topic
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table topic
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table topic
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    public TopicExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table topic
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table topic
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTopicTitleIsNull() {
            addCriterion("topic_title is null");
            return (Criteria) this;
        }

        public Criteria andTopicTitleIsNotNull() {
            addCriterion("topic_title is not null");
            return (Criteria) this;
        }

        public Criteria andTopicTitleEqualTo(String value) {
            addCriterion("topic_title =", value, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleNotEqualTo(String value) {
            addCriterion("topic_title <>", value, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleGreaterThan(String value) {
            addCriterion("topic_title >", value, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleGreaterThanOrEqualTo(String value) {
            addCriterion("topic_title >=", value, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleLessThan(String value) {
            addCriterion("topic_title <", value, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleLessThanOrEqualTo(String value) {
            addCriterion("topic_title <=", value, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleLike(String value) {
            addCriterion("topic_title like", value, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleNotLike(String value) {
            addCriterion("topic_title not like", value, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleIn(List<String> values) {
            addCriterion("topic_title in", values, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleNotIn(List<String> values) {
            addCriterion("topic_title not in", values, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleBetween(String value1, String value2) {
            addCriterion("topic_title between", value1, value2, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicTitleNotBetween(String value1, String value2) {
            addCriterion("topic_title not between", value1, value2, "topicTitle");
            return (Criteria) this;
        }

        public Criteria andTopicCourseIsNull() {
            addCriterion("topic_course is null");
            return (Criteria) this;
        }

        public Criteria andTopicCourseIsNotNull() {
            addCriterion("topic_course is not null");
            return (Criteria) this;
        }

        public Criteria andTopicCourseEqualTo(String value) {
            addCriterion("topic_course =", value, "topicCourse");
            return (Criteria) this;
        }

        public Criteria andTopicCourseNotEqualTo(String value) {
            addCriterion("topic_course <>", value, "topicCourse");
            return (Criteria) this;
        }

        public Criteria andTopicCourseGreaterThan(String value) {
            addCriterion("topic_course >", value, "topicCourse");
            return (Criteria) this;
        }

        public Criteria andTopicCourseGreaterThanOrEqualTo(String value) {
            addCriterion("topic_course >=", value, "topicCourse");
            return (Criteria) this;
        }

        public Criteria andTopicCourseLessThan(String value) {
            addCriterion("topic_course <", value, "topicCourse");
            return (Criteria) this;
        }

        public Criteria andTopicCourseLessThanOrEqualTo(String value) {
            addCriterion("topic_course <=", value, "topicCourse");
            return (Criteria) this;
        }

        public Criteria andTopicCourseLike(String value) {
            addCriterion("topic_course like", value, "topicCourse");
            return (Criteria) this;
        }

        public Criteria andTopicCourseNotLike(String value) {
            addCriterion("topic_course not like", value, "topicCourse");
            return (Criteria) this;
        }

        public Criteria andTopicCourseIn(List<String> values) {
            addCriterion("topic_course in", values, "topicCourse");
            return (Criteria) this;
        }

        public Criteria andTopicCourseNotIn(List<String> values) {
            addCriterion("topic_course not in", values, "topicCourse");
            return (Criteria) this;
        }

        public Criteria andTopicCourseBetween(String value1, String value2) {
            addCriterion("topic_course between", value1, value2, "topicCourse");
            return (Criteria) this;
        }

        public Criteria andTopicCourseNotBetween(String value1, String value2) {
            addCriterion("topic_course not between", value1, value2, "topicCourse");
            return (Criteria) this;
        }

        public Criteria andTopicSemesterIsNull() {
            addCriterion("topic_semester is null");
            return (Criteria) this;
        }

        public Criteria andTopicSemesterIsNotNull() {
            addCriterion("topic_semester is not null");
            return (Criteria) this;
        }

        public Criteria andTopicSemesterEqualTo(String value) {
            addCriterion("topic_semester =", value, "topicSemester");
            return (Criteria) this;
        }

        public Criteria andTopicSemesterNotEqualTo(String value) {
            addCriterion("topic_semester <>", value, "topicSemester");
            return (Criteria) this;
        }

        public Criteria andTopicSemesterGreaterThan(String value) {
            addCriterion("topic_semester >", value, "topicSemester");
            return (Criteria) this;
        }

        public Criteria andTopicSemesterGreaterThanOrEqualTo(String value) {
            addCriterion("topic_semester >=", value, "topicSemester");
            return (Criteria) this;
        }

        public Criteria andTopicSemesterLessThan(String value) {
            addCriterion("topic_semester <", value, "topicSemester");
            return (Criteria) this;
        }

        public Criteria andTopicSemesterLessThanOrEqualTo(String value) {
            addCriterion("topic_semester <=", value, "topicSemester");
            return (Criteria) this;
        }

        public Criteria andTopicSemesterLike(String value) {
            addCriterion("topic_semester like", value, "topicSemester");
            return (Criteria) this;
        }

        public Criteria andTopicSemesterNotLike(String value) {
            addCriterion("topic_semester not like", value, "topicSemester");
            return (Criteria) this;
        }

        public Criteria andTopicSemesterIn(List<String> values) {
            addCriterion("topic_semester in", values, "topicSemester");
            return (Criteria) this;
        }

        public Criteria andTopicSemesterNotIn(List<String> values) {
            addCriterion("topic_semester not in", values, "topicSemester");
            return (Criteria) this;
        }

        public Criteria andTopicSemesterBetween(String value1, String value2) {
            addCriterion("topic_semester between", value1, value2, "topicSemester");
            return (Criteria) this;
        }

        public Criteria andTopicSemesterNotBetween(String value1, String value2) {
            addCriterion("topic_semester not between", value1, value2, "topicSemester");
            return (Criteria) this;
        }

        public Criteria andTopicTypeIsNull() {
            addCriterion("topic_type is null");
            return (Criteria) this;
        }

        public Criteria andTopicTypeIsNotNull() {
            addCriterion("topic_type is not null");
            return (Criteria) this;
        }

        public Criteria andTopicTypeEqualTo(String value) {
            addCriterion("topic_type =", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotEqualTo(String value) {
            addCriterion("topic_type <>", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeGreaterThan(String value) {
            addCriterion("topic_type >", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeGreaterThanOrEqualTo(String value) {
            addCriterion("topic_type >=", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeLessThan(String value) {
            addCriterion("topic_type <", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeLessThanOrEqualTo(String value) {
            addCriterion("topic_type <=", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeLike(String value) {
            addCriterion("topic_type like", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotLike(String value) {
            addCriterion("topic_type not like", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeIn(List<String> values) {
            addCriterion("topic_type in", values, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotIn(List<String> values) {
            addCriterion("topic_type not in", values, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeBetween(String value1, String value2) {
            addCriterion("topic_type between", value1, value2, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotBetween(String value1, String value2) {
            addCriterion("topic_type not between", value1, value2, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicSourceIsNull() {
            addCriterion("topic_source is null");
            return (Criteria) this;
        }

        public Criteria andTopicSourceIsNotNull() {
            addCriterion("topic_source is not null");
            return (Criteria) this;
        }

        public Criteria andTopicSourceEqualTo(String value) {
            addCriterion("topic_source =", value, "topicSource");
            return (Criteria) this;
        }

        public Criteria andTopicSourceNotEqualTo(String value) {
            addCriterion("topic_source <>", value, "topicSource");
            return (Criteria) this;
        }

        public Criteria andTopicSourceGreaterThan(String value) {
            addCriterion("topic_source >", value, "topicSource");
            return (Criteria) this;
        }

        public Criteria andTopicSourceGreaterThanOrEqualTo(String value) {
            addCriterion("topic_source >=", value, "topicSource");
            return (Criteria) this;
        }

        public Criteria andTopicSourceLessThan(String value) {
            addCriterion("topic_source <", value, "topicSource");
            return (Criteria) this;
        }

        public Criteria andTopicSourceLessThanOrEqualTo(String value) {
            addCriterion("topic_source <=", value, "topicSource");
            return (Criteria) this;
        }

        public Criteria andTopicSourceLike(String value) {
            addCriterion("topic_source like", value, "topicSource");
            return (Criteria) this;
        }

        public Criteria andTopicSourceNotLike(String value) {
            addCriterion("topic_source not like", value, "topicSource");
            return (Criteria) this;
        }

        public Criteria andTopicSourceIn(List<String> values) {
            addCriterion("topic_source in", values, "topicSource");
            return (Criteria) this;
        }

        public Criteria andTopicSourceNotIn(List<String> values) {
            addCriterion("topic_source not in", values, "topicSource");
            return (Criteria) this;
        }

        public Criteria andTopicSourceBetween(String value1, String value2) {
            addCriterion("topic_source between", value1, value2, "topicSource");
            return (Criteria) this;
        }

        public Criteria andTopicSourceNotBetween(String value1, String value2) {
            addCriterion("topic_source not between", value1, value2, "topicSource");
            return (Criteria) this;
        }

        public Criteria andTopicIntegratedCurriculumIsNull() {
            addCriterion("topic_integrated_curriculum is null");
            return (Criteria) this;
        }

        public Criteria andTopicIntegratedCurriculumIsNotNull() {
            addCriterion("topic_integrated_curriculum is not null");
            return (Criteria) this;
        }

        public Criteria andTopicIntegratedCurriculumEqualTo(String value) {
            addCriterion("topic_integrated_curriculum =", value, "topicIntegratedCurriculum");
            return (Criteria) this;
        }

        public Criteria andTopicIntegratedCurriculumNotEqualTo(String value) {
            addCriterion("topic_integrated_curriculum <>", value, "topicIntegratedCurriculum");
            return (Criteria) this;
        }

        public Criteria andTopicIntegratedCurriculumGreaterThan(String value) {
            addCriterion("topic_integrated_curriculum >", value, "topicIntegratedCurriculum");
            return (Criteria) this;
        }

        public Criteria andTopicIntegratedCurriculumGreaterThanOrEqualTo(String value) {
            addCriterion("topic_integrated_curriculum >=", value, "topicIntegratedCurriculum");
            return (Criteria) this;
        }

        public Criteria andTopicIntegratedCurriculumLessThan(String value) {
            addCriterion("topic_integrated_curriculum <", value, "topicIntegratedCurriculum");
            return (Criteria) this;
        }

        public Criteria andTopicIntegratedCurriculumLessThanOrEqualTo(String value) {
            addCriterion("topic_integrated_curriculum <=", value, "topicIntegratedCurriculum");
            return (Criteria) this;
        }

        public Criteria andTopicIntegratedCurriculumLike(String value) {
            addCriterion("topic_integrated_curriculum like", value, "topicIntegratedCurriculum");
            return (Criteria) this;
        }

        public Criteria andTopicIntegratedCurriculumNotLike(String value) {
            addCriterion("topic_integrated_curriculum not like", value, "topicIntegratedCurriculum");
            return (Criteria) this;
        }

        public Criteria andTopicIntegratedCurriculumIn(List<String> values) {
            addCriterion("topic_integrated_curriculum in", values, "topicIntegratedCurriculum");
            return (Criteria) this;
        }

        public Criteria andTopicIntegratedCurriculumNotIn(List<String> values) {
            addCriterion("topic_integrated_curriculum not in", values, "topicIntegratedCurriculum");
            return (Criteria) this;
        }

        public Criteria andTopicIntegratedCurriculumBetween(String value1, String value2) {
            addCriterion("topic_integrated_curriculum between", value1, value2, "topicIntegratedCurriculum");
            return (Criteria) this;
        }

        public Criteria andTopicIntegratedCurriculumNotBetween(String value1, String value2) {
            addCriterion("topic_integrated_curriculum not between", value1, value2, "topicIntegratedCurriculum");
            return (Criteria) this;
        }

        public Criteria andTopicContentIsNull() {
            addCriterion("topic_content is null");
            return (Criteria) this;
        }

        public Criteria andTopicContentIsNotNull() {
            addCriterion("topic_content is not null");
            return (Criteria) this;
        }

        public Criteria andTopicContentEqualTo(String value) {
            addCriterion("topic_content =", value, "topicContent");
            return (Criteria) this;
        }

        public Criteria andTopicContentNotEqualTo(String value) {
            addCriterion("topic_content <>", value, "topicContent");
            return (Criteria) this;
        }

        public Criteria andTopicContentGreaterThan(String value) {
            addCriterion("topic_content >", value, "topicContent");
            return (Criteria) this;
        }

        public Criteria andTopicContentGreaterThanOrEqualTo(String value) {
            addCriterion("topic_content >=", value, "topicContent");
            return (Criteria) this;
        }

        public Criteria andTopicContentLessThan(String value) {
            addCriterion("topic_content <", value, "topicContent");
            return (Criteria) this;
        }

        public Criteria andTopicContentLessThanOrEqualTo(String value) {
            addCriterion("topic_content <=", value, "topicContent");
            return (Criteria) this;
        }

        public Criteria andTopicContentLike(String value) {
            addCriterion("topic_content like", value, "topicContent");
            return (Criteria) this;
        }

        public Criteria andTopicContentNotLike(String value) {
            addCriterion("topic_content not like", value, "topicContent");
            return (Criteria) this;
        }

        public Criteria andTopicContentIn(List<String> values) {
            addCriterion("topic_content in", values, "topicContent");
            return (Criteria) this;
        }

        public Criteria andTopicContentNotIn(List<String> values) {
            addCriterion("topic_content not in", values, "topicContent");
            return (Criteria) this;
        }

        public Criteria andTopicContentBetween(String value1, String value2) {
            addCriterion("topic_content between", value1, value2, "topicContent");
            return (Criteria) this;
        }

        public Criteria andTopicContentNotBetween(String value1, String value2) {
            addCriterion("topic_content not between", value1, value2, "topicContent");
            return (Criteria) this;
        }

        public Criteria andTopicRequirementsIsNull() {
            addCriterion("topic_requirements is null");
            return (Criteria) this;
        }

        public Criteria andTopicRequirementsIsNotNull() {
            addCriterion("topic_requirements is not null");
            return (Criteria) this;
        }

        public Criteria andTopicRequirementsEqualTo(String value) {
            addCriterion("topic_requirements =", value, "topicRequirements");
            return (Criteria) this;
        }

        public Criteria andTopicRequirementsNotEqualTo(String value) {
            addCriterion("topic_requirements <>", value, "topicRequirements");
            return (Criteria) this;
        }

        public Criteria andTopicRequirementsGreaterThan(String value) {
            addCriterion("topic_requirements >", value, "topicRequirements");
            return (Criteria) this;
        }

        public Criteria andTopicRequirementsGreaterThanOrEqualTo(String value) {
            addCriterion("topic_requirements >=", value, "topicRequirements");
            return (Criteria) this;
        }

        public Criteria andTopicRequirementsLessThan(String value) {
            addCriterion("topic_requirements <", value, "topicRequirements");
            return (Criteria) this;
        }

        public Criteria andTopicRequirementsLessThanOrEqualTo(String value) {
            addCriterion("topic_requirements <=", value, "topicRequirements");
            return (Criteria) this;
        }

        public Criteria andTopicRequirementsLike(String value) {
            addCriterion("topic_requirements like", value, "topicRequirements");
            return (Criteria) this;
        }

        public Criteria andTopicRequirementsNotLike(String value) {
            addCriterion("topic_requirements not like", value, "topicRequirements");
            return (Criteria) this;
        }

        public Criteria andTopicRequirementsIn(List<String> values) {
            addCriterion("topic_requirements in", values, "topicRequirements");
            return (Criteria) this;
        }

        public Criteria andTopicRequirementsNotIn(List<String> values) {
            addCriterion("topic_requirements not in", values, "topicRequirements");
            return (Criteria) this;
        }

        public Criteria andTopicRequirementsBetween(String value1, String value2) {
            addCriterion("topic_requirements between", value1, value2, "topicRequirements");
            return (Criteria) this;
        }

        public Criteria andTopicRequirementsNotBetween(String value1, String value2) {
            addCriterion("topic_requirements not between", value1, value2, "topicRequirements");
            return (Criteria) this;
        }

        public Criteria andTopicMainDifficultiesIsNull() {
            addCriterion("topic_main_difficulties is null");
            return (Criteria) this;
        }

        public Criteria andTopicMainDifficultiesIsNotNull() {
            addCriterion("topic_main_difficulties is not null");
            return (Criteria) this;
        }

        public Criteria andTopicMainDifficultiesEqualTo(String value) {
            addCriterion("topic_main_difficulties =", value, "topicMainDifficulties");
            return (Criteria) this;
        }

        public Criteria andTopicMainDifficultiesNotEqualTo(String value) {
            addCriterion("topic_main_difficulties <>", value, "topicMainDifficulties");
            return (Criteria) this;
        }

        public Criteria andTopicMainDifficultiesGreaterThan(String value) {
            addCriterion("topic_main_difficulties >", value, "topicMainDifficulties");
            return (Criteria) this;
        }

        public Criteria andTopicMainDifficultiesGreaterThanOrEqualTo(String value) {
            addCriterion("topic_main_difficulties >=", value, "topicMainDifficulties");
            return (Criteria) this;
        }

        public Criteria andTopicMainDifficultiesLessThan(String value) {
            addCriterion("topic_main_difficulties <", value, "topicMainDifficulties");
            return (Criteria) this;
        }

        public Criteria andTopicMainDifficultiesLessThanOrEqualTo(String value) {
            addCriterion("topic_main_difficulties <=", value, "topicMainDifficulties");
            return (Criteria) this;
        }

        public Criteria andTopicMainDifficultiesLike(String value) {
            addCriterion("topic_main_difficulties like", value, "topicMainDifficulties");
            return (Criteria) this;
        }

        public Criteria andTopicMainDifficultiesNotLike(String value) {
            addCriterion("topic_main_difficulties not like", value, "topicMainDifficulties");
            return (Criteria) this;
        }

        public Criteria andTopicMainDifficultiesIn(List<String> values) {
            addCriterion("topic_main_difficulties in", values, "topicMainDifficulties");
            return (Criteria) this;
        }

        public Criteria andTopicMainDifficultiesNotIn(List<String> values) {
            addCriterion("topic_main_difficulties not in", values, "topicMainDifficulties");
            return (Criteria) this;
        }

        public Criteria andTopicMainDifficultiesBetween(String value1, String value2) {
            addCriterion("topic_main_difficulties between", value1, value2, "topicMainDifficulties");
            return (Criteria) this;
        }

        public Criteria andTopicMainDifficultiesNotBetween(String value1, String value2) {
            addCriterion("topic_main_difficulties not between", value1, value2, "topicMainDifficulties");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNull() {
            addCriterion("teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("teacher_name =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("teacher_name <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("teacher_name >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_name >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("teacher_name <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_name <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("teacher_name like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("teacher_name not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("teacher_name in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("teacher_name not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("teacher_name between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("teacher_name not between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTopicStatusIsNull() {
            addCriterion("topic_status is null");
            return (Criteria) this;
        }

        public Criteria andTopicStatusIsNotNull() {
            addCriterion("topic_status is not null");
            return (Criteria) this;
        }

        public Criteria andTopicStatusEqualTo(String value) {
            addCriterion("topic_status =", value, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusNotEqualTo(String value) {
            addCriterion("topic_status <>", value, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusGreaterThan(String value) {
            addCriterion("topic_status >", value, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusGreaterThanOrEqualTo(String value) {
            addCriterion("topic_status >=", value, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusLessThan(String value) {
            addCriterion("topic_status <", value, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusLessThanOrEqualTo(String value) {
            addCriterion("topic_status <=", value, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusLike(String value) {
            addCriterion("topic_status like", value, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusNotLike(String value) {
            addCriterion("topic_status not like", value, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusIn(List<String> values) {
            addCriterion("topic_status in", values, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusNotIn(List<String> values) {
            addCriterion("topic_status not in", values, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusBetween(String value1, String value2) {
            addCriterion("topic_status between", value1, value2, "topicStatus");
            return (Criteria) this;
        }

        public Criteria andTopicStatusNotBetween(String value1, String value2) {
            addCriterion("topic_status not between", value1, value2, "topicStatus");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table topic
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table topic
     *
     * @mbggenerated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}