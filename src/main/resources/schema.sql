-- -----------------------------------------------------
-- Table `issuesticker`.`t_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `issuesticker`.`t_user` (
  `idx` INT(11) NOT NULL AUTO_INCREMENT COMMENT '회원 테이블 인텍스',
  `id` VARCHAR(50) NOT NULL COMMENT '사용자 아이디',
  `password` VARCHAR(200) NOT NULL COMMENT '패스워드',
  `name` VARCHAR(20) NULL COMMENT '사용자 이름',
  `email` VARCHAR(50) NULL COMMENT '사용자 이메일',
  `is_access` TINYINT(1) NULL COMMENT '사용자 사이트 접속 승인 여부',
  `registered_date` DATETIME NULL COMMENT '등록일자',
  `modified_date` DATETIME NULL COMMENT '변경일자',
  PRIMARY KEY (`idx`),
  UNIQUE INDEX `id_unique` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '회원 테이블';


-- -----------------------------------------------------
-- Table `issuesticker`.`t_project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `issuesticker`.`t_project` (
  `idx` INT(11) NOT NULL AUTO_INCREMENT COMMENT '프로젝트 테이블 인덱스',
  `project_code` VARCHAR(50) NOT NULL COMMENT '프로젝트 코드 (이슈 스티커 구문값)',
  `title` VARCHAR(50) NULL COMMENT '프로젝트 타이틀',
  `description` LONGTEXT NULL COMMENT '프로젝트 상세설명',
  `registered_date` DATETIME NULL COMMENT '등록일자',
  `modified_date` DATETIME NULL COMMENT '변경일자',
  PRIMARY KEY (`idx`),
  UNIQUE INDEX `project_code_unique` (`project_code` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '프로젝트 테이블';


-- -----------------------------------------------------
-- Table `issuesticker`.`t_user_to_project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `issuesticker`.`t_user_to_project` (
  `user_idx` INT(11) NOT NULL COMMENT '회원 테이블 외래키',
  `project_idx` INT(11) NOT NULL COMMENT '프로젝트 테이블 외래키',
  INDEX `fk_utp_user_idx` (`user_idx` ASC),
  INDEX `fk_utp_project_idx` (`project_idx` ASC),
  PRIMARY KEY (`user_idx`, `project_idx`),
  CONSTRAINT `fk_utp_user`
    FOREIGN KEY (`user_idx`)
    REFERENCES `issuesticker`.`t_user` (`idx`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_utp_project`
    FOREIGN KEY (`project_idx`)
    REFERENCES `issuesticker`.`t_project` (`idx`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '회원, 프로젝트 N:M 매핑 테이블';


-- -----------------------------------------------------
-- Table `issuesticker`.`t_deployment_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `issuesticker`.`t_deployment_type` (
  `idx` INT(11) NOT NULL COMMENT '프로젝트 배포 타입 테이블 인덱스',
  `project_idx` INT(11) NULL COMMENT '프로젝트 테이블 외래키',
  `deployment_schedule_idx` INT(11) NOT NULL COMMENT '프로젝트 배포 스케줄 테이블 외래키',
  `title` VARCHAR(50) NULL COMMENT '배포 유형 제목',
  `code` VARCHAR(2) NOT NULL COMMENT '배포 유형코드',
  `description` LONGTEXT NULL COMMENT '유형 상세 설명',
  `registered_date` DATETIME NULL COMMENT '등록일자',
  `modified_date` DATETIME NULL COMMENT '변경일자',
  PRIMARY KEY (`idx`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '프로젝트 배포 타입 테이블';


-- -----------------------------------------------------
-- Table `issuesticker`.`t_project_to_deployment_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `issuesticker`.`t_project_to_deployment_type` (
  `project_idx` INT(11) NOT NULL COMMENT '프로젝트 테이블 외래키',
  `deployment_type_idx` INT(11) NOT NULL COMMENT '프로젝트 배포 타입 테이블 외래키',
  INDEX `fk_ptd_project_idx` (`project_idx` ASC),
  INDEX `fk_ptd_deployment_type_idx` (`deployment_type_idx` ASC),
  PRIMARY KEY (`project_idx`, `deployment_type_idx`),
  CONSTRAINT `fk_ptd_project`
    FOREIGN KEY (`project_idx`)
    REFERENCES `issuesticker`.`t_project` (`idx`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ptd_deployment_type`
    FOREIGN KEY (`deployment_type_idx`)
    REFERENCES `issuesticker`.`t_deployment_type` (`idx`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '프로젝트, 프로젝트 배포 타입 N:M 매핑 테이블';


-- -----------------------------------------------------
-- Table `issuesticker`.`t_deployment_schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `issuesticker`.`t_deployment_schedule` (
  `idx` INT(11) NOT NULL COMMENT '프로젝트 배포 스케줄 테이블 인덱스',
  `project_idx` INT(11) NOT NULL COMMENT '프로젝트 테이블 외래키',
  `deployment_type_idx` INT(11) NOT NULL COMMENT '프로젝트 배포 타입 테이블 외래키',
  `title` VARCHAR(50) NULL COMMENT '프로젝트 배포 타이틀 (정기배포, 긴급배포 등등)',
  `merge_finish_date` DATETIME NULL COMMENT '배포 대기 브런치 머지 최종일자',
  `deploy_date` DATETIME NULL COMMENT '배포 작업일자',
  `modified_date` DATETIME NULL COMMENT '등록일자',
  `registered_date` DATETIME NULL COMMENT '변경일자',
  PRIMARY KEY (`idx`),
  INDEX `fk_project_idx` (`project_idx` ASC),
  CONSTRAINT `fk_project`
    FOREIGN KEY (`project_idx`)
    REFERENCES `issuesticker`.`t_project` (`idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '프로젝트 배포 스케줄 테이블';


-- -----------------------------------------------------
-- Table `issuesticker`.`t_deployment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `issuesticker`.`t_deployment` (
  `idx` INT(11) NOT NULL,
  `deployment_schedule_idx` INT(11) NOT NULL COMMENT '프로젝트 배포 스케줄 테이블 외래키',
  `title` VARCHAR(50) NULL,
  `registered_date` DATETIME NULL COMMENT '등록일자',
  `modified_date` DATETIME NULL COMMENT '변경일자',
  PRIMARY KEY (`idx`),
  INDEX `fk_deployment_schedule_idx` (`deployment_schedule_idx` ASC),
  CONSTRAINT `fk_deployment_schedule`
    FOREIGN KEY (`deployment_schedule_idx`)
    REFERENCES `issuesticker`.`t_deployment_schedule` (`idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = '프로젝트 배포 테이블';


-- -----------------------------------------------------
-- Table `issuesticker`.`t_flow_branch_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `issuesticker`.`t_flow_branch_info` (
  `idx` INT(11) NOT NULL AUTO_INCREMENT COMMENT 'git 배포 흐림용 브런치 정보 테이블 인덱스',
  `project_idx` INT(11) NOT NULL COMMENT '프로젝트 배포 흐름 관리 테이블인텍스',
  `branch_code` VARCHAR(50) NOT NULL COMMENT '브런치 코드',
  `title` VARCHAR(50) NULL COMMENT '브런치 타이틀',
  `description` LONGTEXT NULL COMMENT '브펀치 상세 내용',
  `registered_date` DATETIME NULL COMMENT '등록일자',
  `modified_date` DATETIME NULL COMMENT '변경일자',
  PRIMARY KEY (`idx`),
  INDEX `fk_project_idx_idx` (`project_idx` ASC),
  CONSTRAINT `fk_project_idx`
    FOREIGN KEY (`project_idx`)
    REFERENCES `issuesticker`.`t_project` (`idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = 'git 배포 흐림용 브런치 정보 테이블';


-- -----------------------------------------------------
-- Table `issuesticker`.`t_issue_sticker_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `issuesticker`.`t_issue_sticker_status` (
  `idx` INT(11) NOT NULL COMMENT '이슈 스티커 진행 상태 테이블 인덱스',
  `deployment_type_idx` INT(11) NULL,
  `target_branch_idx` INT(11) NULL,
  `next_status_idx` INT(11) NULL COMMENT '다음 이슈 스티커 진행 상태',
  `is_branch_merge` TINYINT(1) NULL COMMENT '프런치 merge 가능 여부',
  `status_code` CHAR(2) NULL COMMENT '이슈 처리 진행 상태 코드',
  `title` VARCHAR(150) NULL COMMENT '상태 제목',
  `sort` INT(11) NULL COMMENT '진행 상태 정렬',
  `description` LONGTEXT NULL COMMENT '상태 상세 설명',
  `registered_date` DATETIME NULL,
  `modified_date` DATETIME NULL,
  PRIMARY KEY (`idx`),
  INDEX `fk_deployment_type_idx` (`deployment_type_idx` ASC),
  INDEX `fk_target_branch_idx` (`target_branch_idx` ASC),
  INDEX `fk_next_status_idx` (`next_status_idx` ASC),
  CONSTRAINT `fk_deployment_type`
    FOREIGN KEY (`deployment_type_idx`)
    REFERENCES `issuesticker`.`t_deployment_type` (`idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_target_branch`
    FOREIGN KEY (`target_branch_idx`)
    REFERENCES `issuesticker`.`t_flow_branch_info` (`idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_next_status`
    FOREIGN KEY (`next_status_idx`)
    REFERENCES `issuesticker`.`t_issue_sticker_status` (`idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = '이슈 스티커 진행 상태 테이블';


-- -----------------------------------------------------
-- Table `issuesticker`.`t_issue_sticker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `issuesticker`.`t_issue_sticker` (
  `idx` INT(11) NOT NULL AUTO_INCREMENT COMMENT '이슈 스티커 테이블 인덱스',
  `issue_sticker_status_idx` INT(11) NOT NULL COMMENT '이슈 스티커 진행 상태 테이블 외래키 (이슈 처리 상태)',
  `project_key_idx` VARCHAR(50) NOT NULL COMMENT '프로젝트.코드 (이슈 스티커 분류 코드)',
  `creater_idx` INT(11) NULL COMMENT '이슈 등록자 (사용자 테이블 외래키)',
  `manager_idx` INT(11) NULL COMMENT '이슈 담당자 (사용자 테이블 외래키)',
  `worker_idx` INT(11) NULL COMMENT '이슈 작업자  (사용자 테이블 외래키)',
  `title` VARCHAR(150) NULL COMMENT '이슈 제목',
  `description` LONGTEXT NULL COMMENT '이슈 상세 내용',
  `work_branch` VARCHAR(50) NULL COMMENT '이슈 작용을 위해 생성한 브런치 코드',
  `to_do_date` DATETIME NULL COMMENT '이슈 해결 희망일 (이슈 등록자가 등록)',
  `deployment_date` DATETIME NULL COMMENT '배포 희망 일자 지정 (이슈 작업자가 등록, 배포관리에서 등록된 날짜 중에서 선택)',
  `registered_date` DATETIME NULL,
  `modified_date` DATETIME NULL,
  PRIMARY KEY (`idx`),
  INDEX `fk_issue_sticker_status_idx` (`issue_sticker_status_idx` ASC),
  CONSTRAINT `fk_issue_sticker_status`
    FOREIGN KEY (`issue_sticker_status_idx`)
    REFERENCES `issuesticker`.`t_issue_sticker_status` (`idx`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
COMMENT = '이슈 스티커 테이블';


-- -----------------------------------------------------
-- Table `issuesticker`.`t_deployment to_issue_sticker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `issuesticker`.`t_deployment to_issue_sticker` (
  `deployment_idx` INT(11) NOT NULL COMMENT '프로젝트 배포 테이블 외래키',
  `issue_sticker_idx` INT(11) NOT NULL COMMENT '이슈 스티커 테이블 외래키',
  INDEX `fk_dti_deployment_idx` (`deployment_idx` ASC),
  INDEX `fk_dti_issue_sticker_idx` (`issue_sticker_idx` ASC),
  PRIMARY KEY (`deployment_idx`, `issue_sticker_idx`),
  CONSTRAINT `fk_dti_deployment`
    FOREIGN KEY (`deployment_idx`)
    REFERENCES `issuesticker`.`t_deployment` (`idx`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_dti_issue_sticker`
    FOREIGN KEY (`issue_sticker_idx`)
    REFERENCES `issuesticker`.`t_issue_sticker` (`idx`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
COMMENT = '프로젝트 배포, 이슈 스티커 N:M 매핑 테이블';


-- -----------------------------------------------------
-- Table `issuesticker`.`t_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `issuesticker`.`t_role` (
  `idx` INT(11) NOT NULL AUTO_INCREMENT,
  `role_code` VARCHAR(10) NULL,
  PRIMARY KEY (`idx`));


-- -----------------------------------------------------
-- Table `issuesticker`.`t_user_to_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `issuesticker`.`t_user_to_role` (
  `user_idx` INT(11) NOT NULL COMMENT '회원 테이블 외래키',
  `role_idx` INT(11) NOT NULL COMMENT '프로젝트 테이블 외래키',
  INDEX `fk_utr_user_idx` (`user_idx` ASC),
  INDEX `fk_utr_role_idx` (`role_idx` ASC),
  PRIMARY KEY (`user_idx`, `role_idx`),
  CONSTRAINT `fk_utr_user`
    FOREIGN KEY (`user_idx`)
    REFERENCES `issuesticker`.`t_user` (`idx`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_utr_role`
    FOREIGN KEY (`role_idx`)
    REFERENCES `issuesticker`.`t_role` (`idx`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '회원, 프로젝트 N:M 매핑 테이블';