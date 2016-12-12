package com.tf.ws.model;

/**
 * Created by heather on 5/11/2014.
 *
 * http://goodsecurityquestions.com/examples.htm
 */
public enum SecurityQuestion
{
	NICKNAME("nickname"),
	SPOUSE_CITY("spouseCity"),
	CHILDHOOD_FRIEND("childhoodFriend"),
	THIRD_GRADE_STREET("thirdGradeStreet"),
	OLDEST_SIBLING_BIRTH("oldestSiblingBirth"),
	OLDEST_CHILD_MIDDLE("oldestChildMiddle"),
	OLDEST_SIBLING_MIDDLE("oldestSiblingMiddle"),
	SIXTH_GRADE_SCHOOL("sixthGradeSchool"),
	CHILDHOOD_PHONE("childhoodPhone"),
	OLDEST_COUSIN_NAME("oldestCousinName"),
	FIRST_STUFFED_ANIMAL("firstStuffedAnimal"),
	PARENTS_MEET_CITY("parentsMeetCity"),
	FIRST_KISS_LOCATION("firstKissLocation"),
	FIRST_NAME_FIRST_KISS("firstNameFirstKiss"),
	THIRD_GRADE_TEACHER("thirdGradeTeacher"),
	CITY_NEAREST_SIBLING("cityNearestSibling"),
	OLDEST_BROTHER_BIRTH("oldestBrotherBirth"),
	MATERNAL_GRAND_MOTHER_MAIDEN("maternalGrandmotherMaiden"),
	CITY_FIRST_JOB("cityFirstJob"),
	WEDDING_RECEPTION_LOCATION("weddingReceptionLocation"),
	COLLEGE_APPLIED_NOT_ATTENDED("collegeAppliedNotAttended"),
	WHERE_911("where911");

	private String label;

	SecurityQuestion(String label) {
		this.label = label;
	}
	public String getLabel() {
		return this.label;
	}

}
