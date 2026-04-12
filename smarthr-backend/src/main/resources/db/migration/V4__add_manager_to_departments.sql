ALTER TABLE departments
ADD COLUMN manager_id UUID REFERENCES employees(id);