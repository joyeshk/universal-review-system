#create a security group for RDS Database Instance
resource "aws_security_group" "rds_sg" {
  vpc_id = aws_vpc.aws-vpc.id
  name   = "${var.app_name}-rds_sg"
  ingress {
    from_port   = 3306
    to_port     = 3306
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_db_subnet_group" "rdsmain_public" {
  name        = "rdsmain-public"
  description = "Public subnets for RDS instance"
  subnet_ids  = aws_subnet.public.*.id
}

#create a RDS Database Instance
resource "aws_db_instance" "myinstance" {
  engine                 = "mysql"
  identifier             = "myrdsinstance"
  allocated_storage      = 20
  engine_version         = "5.7"
  instance_class         = "db.t3.micro"
  username               = "application_user"
  password               = "abcd1234"
  parameter_group_name   = "default.mysql5.7"
  vpc_security_group_ids = ["${aws_security_group.rds_sg.id}"]
  skip_final_snapshot    = true
  publicly_accessible    = true
  db_subnet_group_name   = aws_db_subnet_group.rdsmain_public.name
}
