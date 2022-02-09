package at.htl.workloads.classroom;

import at.htl.model.StudentCountDTO;
import at.htl.model.TeacherHourCountDTO;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClassroomRepositoryImpl implements ClassroomRepository {

    @Inject
    Logger LOG;

    private final EntityManager entityManager;

    public ClassroomRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Classroom> findAll() {
        TypedQuery<Classroom> typedQuery =
                this.entityManager.createQuery("select c from Classroom c", Classroom.class);
        return typedQuery.getResultList();
    }

    @Override
    public Classroom findById(long id) {
        TypedQuery<Classroom> typedQuery =
                this.entityManager.createQuery("select c from Classroom c where c.id = :ID", Classroom.class);
        typedQuery.setParameter("ID", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void add(Classroom classroom) {
        this.entityManager.persist(classroom);
    }

    @Override
    public void remove(Classroom classroom) {
        this.entityManager.remove(classroom);
    }

    @Override
    public Classroom update(Classroom classroom) {
        return this.entityManager.merge(classroom);
    }

    @Override
    public List<ClassroomLesson> getLessonsForDayOfWeek(Classroom classroom, DayOfWeek dayOfWeek) {
        TypedQuery<ClassroomLesson> typedQuery =
                this.entityManager.createQuery("select cl from ClassroomLesson cl where cl.classroom=:CLASSROOM and cl.dayOfWeek=:DOW", ClassroomLesson.class);
        typedQuery.setParameter("CLASSROOM", classroom);
        typedQuery.setParameter("DOW", dayOfWeek);
        return typedQuery.getResultList();
    }

    @Override
    public List<Lesson> findAllLessons() {
        TypedQuery<Lesson> typedQuery = this.entityManager.createQuery("select l from Lesson l", Lesson.class);
        return typedQuery.getResultList();
    }

    @Override
    public void addClassroomLesson(ClassroomLesson classroomLesson) {
        this.entityManager.persist(classroomLesson);
    }


    @Override
    public List<List<ClassroomLesson>> getTimetable(long classroomID) {
        List<List<ClassroomLesson>> lessons = new ArrayList<>();

        Classroom classroom = findById(classroomID);

        LOG.error(classroom);

        for (int i = 0; i < 7; i++ ){
            List<ClassroomLesson> classroomLessonList = getLessonsForDayOfWeek(classroom, DayOfWeek.of(i+1));
            lessons.add(classroomLessonList);
        }
        return lessons;
    }

    @Override
    public List<StudentCountDTO> getClassWithStudentCount() {

        TypedQuery<StudentCountDTO> query =  entityManager.createQuery(
                "Select new at.htl.model.StudentCountDTO(c, count(c))" +
                        " from Student s join s.classroom c" +
                        " group by c",
                StudentCountDTO.class
        );

        return query.getResultList();
    }

    @Override
    public List<TeacherHourCountDTO> getTeacherWithStudentsCount(Long TeacherId) {

        TypedQuery<TeacherHourCountDTO> query = entityManager.createQuery(
                "select new at.htl.model.TeacherHourCountDTO(c.name, count(c))" +
                        " from ClassroomLesson cl join cl.classroom c" +
                        " where cl.teacher.id=?1 group by c.name",
                TeacherHourCountDTO.class
        ).setParameter(1, TeacherId);

        return query.getResultList();
    }
}
