export class Discipline {
    id?: number;
    name: string;
    maxStudents: number;
    studyYear: number;
    category: string;
    teacher: string;
    enrollments?: any[];
  
    constructor(
      id?: number,
      name?: string,
      maxStudents?: number,
      studyYear?: number,
      category?: string,
      teacher?: string,
      enrollments?: any[]
    ) {
      this.id = id;
      this.name = name || '';
      this.maxStudents = maxStudents || 0;
      this.studyYear = studyYear || 0;
      this.category = category || '';
      this.teacher = teacher || '';
      this.enrollments = enrollments || [];
    }
  }
  