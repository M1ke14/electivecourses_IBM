export class Discipline {
    id?: number | undefined;
    name: string | undefined;
    maxStudents: number | undefined;
    studyYear: number | undefined;
    category: string | undefined;
    teacher: string | undefined;
    enrollments?: any[] | undefined;
    [key: string]: any;
}
