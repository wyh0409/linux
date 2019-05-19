CC = gcc
RM = -rm -rf
DEBUG = FALSE

ifeq ($(DEBUG),TRUE)
	LOG = "DEBUG_Game"
	CFLAGS ?= -g -Wall -O0 -D_DEBUG
	OUTPUTNAME := DEBUG_Game
else
	LOG = "Game"
	CFLAGS ?= -Wall -O0
	OUTPUTNAME := Game
endif


TOPDIR = $(PWD)
BUILDDIR = $(TOPDIR)/build
OBJSDIR = $(BUILDDIR)/obj
BINDIR = $(BUILDDIR)/bin
INCDIR = $(TOPDIR)/include
SOURCEDIR = ./package ./ ./lib

OBJ = main.o\
	  login.o\
	  choose.o\
	  game.o\
	  show.o\
	  game_list.o
