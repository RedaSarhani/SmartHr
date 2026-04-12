ALTER TABLE users
ADD COLUMN employee_id UUID REFERENCES employees(id);