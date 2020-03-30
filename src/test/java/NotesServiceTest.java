import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

class MockNotesStorage implements NotesStorage {
	public ArrayList<Note> notes;
	
	public MockNotesStorage() {
		clear();
	}
	
	public void add(Note note) {
		this.notes.add(note);
	}
	
	public List<Note> getAllNotesOf(String name) {
		ArrayList<Note> out = new ArrayList<Note>();
		for (int i = 0; i < notes.size(); i++) {
			if (notes.get(i).getName() == name) {
				out.add(notes.get(i));
			}
		}
		return out;
	}
	
	public void clear() {
		notes = new ArrayList<Note>();
	}
}

class NotesServiceImplTest {
	
	NotesServiceImpl ns;
	MockNotesStorage mock;
	
	@BeforeEach
	void setup() {
        mock = new MockNotesStorage();
		ns = NotesServiceImpl.createWith(mock);
	}
	
	@Test
	void test_NotesService_add() {
		Note note = Note.of("Adam", 3);
		ns.add(note);
		assertTrue(mock.notes.contains(note));
	}
	
	@Test
	void test_NotesService_averageOf() {
        ns.add(Note.of("Adam", 3.0f));
        ns.add(Note.of("Adam", 4.0f));
        assertEquals(3.5f, ns.averageOf("Adam"));
	}
	
	@Test
	void test_NotesService_clear() {
        mock.notes.add(Note.of("Adam", 3.0f));
        ns.clear();
        assertTrue(mock.notes.isEmpty());
	}
}
